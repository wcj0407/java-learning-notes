@echo off
chcp 65001 >nul
setlocal enabledelayedexpansion
cd /d D:\zhuomian\java-learning-notes
set log_file=sync_log.txt

echo ==============================================
echo Java笔记一键同步｜完整版（修复新文件识别）
echo 特性：识别新建/修改/删除文件｜多文件夹自动识别｜冲突拦截｜推送重试
echo       自动过滤Typora临时缓存、系统垃圾文件不提交
echo ==============================================

:: 清理Typora临时缓存、系统缩略图垃圾文件
echo 清理Typora临时缓存、系统缩略图垃圾文件...
git clean -n -f "*.tmp" "*.idle" "Thumbs.db" ".DS_Store" >nul 2>&1
git clean -f "*.tmp" "*.idle" "Thumbs.db" ".DS_Store" >nul 2>&1
echo.

:: ========== 修复点：同时检测已修改文件 + 未跟踪新文件 ==========
:: 1. 检测已提交过的文件是否改动
git diff --quiet HEAD
set has_modify=%errorlevel%
:: 2. 检测全新未追踪文件
git ls-files --others --exclude-standard | findstr . >nul
set has_new=%errorlevel%

if %has_modify% equ 0 if %has_new% equ 1 (
    echo 【提示】未检测到有效文件修改，无需同步，程序退出
    pause
    exit /b
)

echo 1. 拉取 Gitee 远程更新
git pull gitee main
if errorlevel 1 (
    echo 【错误】拉取Gitee时产生代码冲突，请手动解决冲突后再运行脚本
    echo [%date% %time%] 拉取Gitee冲突，同步终止 >> !log_file!
    pause
    exit /b
)
echo.
echo 2. 拉取 GitHub 远程更新
git pull github main
if errorlevel 1 (
    echo 【错误】拉取GitHub时产生代码冲突，请手动解决冲突后再运行脚本
    echo [%date% %time%] 拉取GitHub冲突，同步终止 >> !log_file!
    pause
    exit /b
)
echo.

:: 遍历所有变更(新增/修改/删除)，提取所有独立章节文件夹
set dir_list=
for /f "delims=" %%i in ('git diff --name-only HEAD --diff-filter=ACMRD 2^>nul ^&^& git ls-files --others --exclude-standard 2^>nul') do (
    set file_path=%%i
    :: 跳过临时缓存文件
    echo !file_path! | findstr /i ".tmp .idle Thumbs.db .DS_Store" >nul
    if !errorlevel! equ 1 (
        echo !file_path! | findstr /b "Java/" >nul
        if !errorlevel! equ 0 (
            for /f "tokens=2 delims=/" %%d in ("!file_path!") do (
                set curr_dir=%%d
                echo ;!dir_list!; | findstr /c:";!curr_dir!;" >nul
                if !errorlevel! equ 1 (
                    set dir_list=!dir_list!!curr_dir!、
                )
            )
        )
    )
)

:: 组装自动提交备注
set auto_text=笔记更新
if defined dir_list (
    set auto_text=完成：!dir_list:~0,-1!
)

echo 自动检测所有修改目录：!auto_text!
set input_msg=!auto_text!
set /p input_msg=直接回车使用默认，或自定义更新内容：
echo.

:: 暂存全部有效修改
echo 3. 暂存全部文件修改（自动过滤临时缓存）
git add .
echo.
git commit -m "!input_msg!"
if errorlevel 1 (
    echo 【警告】本次提交无新内容，同步终止
    pause
    exit /b
)
echo.

:: 推送失败自动重试一次
echo 4. 推送至 Gitee
git push gitee main
if errorlevel 1 (
    echo Gitee推送失败，正在重试一次...
    git push gitee main
    if errorlevel 1 (
        echo 【错误】Gitee两次推送均失败，请检查网络/SSH密钥
        echo [%date% %time%] Gitee推送失败｜备注：!input_msg! >> !log_file!
        pause
        exit /b
    )
)
echo.
echo 5. 推送至 GitHub
git push github main
if errorlevel 1 (
    echo GitHub推送失败，正在重试一次...
    git push github main
    if errorlevel 1 (
        echo 【错误】GitHub两次推送均失败，请检查网络/SSH密钥
        echo [%date% %time%] GitHub推送失败｜备注：!input_msg! >> !log_file!
        pause
        exit /b
)

:: 写入同步日志
echo [%date% %time%] 同步成功｜提交信息：!input_msg! >> !log_file!
echo.
echo ============== ✅ Gitee + GitHub 双平台同步完成 ==============
echo 同步记录已保存至 sync_log.txt
pause