@echo off
chcp 65001 >nul
setlocal enabledelayedexpansion
cd /d D:\zhuomian\java-learning-notes
set log_file=sync_log.txt

echo Java笔记同步工具
echo 远程：origin=GitHub gitee=Gitee
echo.

:: 清理临时文件
echo 清理Typora临时缓存
git clean -n -f "*.tmp" "*.idle" "Thumbs.db" ".DS_Store" >nul 2>&1
git clean -f "*.tmp" "*.idle" "Thumbs.db" ".DS_Store" >nul 2>&1
echo.

:: 检测是否存在修改
git diff --quiet HEAD
set has_modify=%errorlevel%
git ls-files --others --exclude-standard | findstr . >nul
set has_new=%errorlevel%

if %has_modify% equ 0 if %has_new% equ 1 (
    echo 无文件修改，程序退出
    pause
    exit /b
)

:: 拉取GitHub origin
echo 1. 拉取GitHub更新
git pull origin main
if errorlevel 1 (
    echo 拉取GitHub冲突，终止同步
    echo [%date% %time%] GitHub拉取冲突 >> !log_file!
    pause
    exit /b
)
echo.

:: 拉取Gitee
echo 2. 拉取Gitee更新
git pull gitee main
if errorlevel 1 (
    echo 拉取Gitee冲突，终止同步
    echo [%date% %time%] Gitee拉取冲突 >> !log_file!
    pause
    exit /b
)
echo.

:: 提取所有修改文件夹
set dir_list=
for /f "delims=" %%i in ('git diff --name-only HEAD --diff-filter=ACMRD 2^>nul ^&^& git ls-files --others --exclude-standard 2^>nul') do (
    set file_path=%%i
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

set auto_text=笔记更新
if defined dir_list (
    set auto_text=完成：!dir_list:~0,-1!
)
echo 检测修改目录：!auto_text!
set input_msg=!auto_text!
set /p input_msg=回车使用默认，或自定义备注：
echo.

:: 提交文件
echo 3. 暂存所有变更
git add .
echo.
git commit -m "!input_msg!"
if errorlevel 1 (
    echo 无新内容，终止同步
    pause
    exit /b
)
echo.

:: 推送GitHub
echo 4. 推送GitHub
git push origin main
if errorlevel 1 (
    echo GitHub推送失败，重试一次
    git push origin main
    if errorlevel 1 (
        echo GitHub推送两次失败
        echo [%date% %time%] GitHub推送失败｜备注：!input_msg! >> !log_file!
        pause
        exit /b
    )
)
echo.

:: 推送Gitee
echo 5. 推送Gitee
git push gitee main
if errorlevel 1 (
    echo Gitee推送失败，重试一次
    git push gitee main
    if errorlevel 1 (
        echo Gitee推送两次失败
        echo [%date% %time%] Gitee推送失败｜备注：!input_msg! >> !log_file!
        pause
        exit /b
    )
)
echo.

:: 写入日志
echo [%date% %time%] 同步成功｜备注：!input_msg! >> !log_file!
echo 同步完成，记录保存至sync_log.txt
pause