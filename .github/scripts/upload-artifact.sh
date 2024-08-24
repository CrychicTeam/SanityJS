#!/bin/bash
set -e

# 第一个参数是文件路径
file_path=$1

# 提取文件名作为 artifact 名称
artifact_name=$(basename "$file_path")

# 使用 upload-artifact 动作上传文件
echo "Uploading $artifact_name"
curl -X POST \
  -H "Authorization: token ${{ secrets.GITHUB_TOKEN }}" \
  -H "Accept: application/vnd.github.v3+json" \
  https://uploads.github.com/repos/CrychicTeam/SanityJS/actions/artifacts \
  --data-binary @"$file_path" \
  -H "Content-Type: application/octet-stream" \
  -f -n -s \
  -F "name=$artifact_name" \
  -F "artifact=@$file_path"