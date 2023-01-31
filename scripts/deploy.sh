# # 가동중인 도커 중단 및 삭제
# #sudo docker ps -a -q --filter "name=kube" | grep -q . && docker stop kube && docker rm kube | true

# sudo docker-compose stop

# # sudo docker rm redis

# # sudo docker rm kube-spring

# # 기존 이미지 삭제
# sudo docker rmi choeuni/kube

# # 도커 실행
# sudo docker-compose up -d

# ## 도커허브 이미지 pull
# #sudo docker pull choeuni/kube

# ## 도커 run
# #docker run -d -p 8081:8081 --name kube choeuni/kube

# # 사용하지 않는 불필요한 이미지 삭제 -> 현재 컨테이너가 물고 있는 이미지는 삭제되지 않습니다.
# sudo docker rmi -f $(docker images -f "dangling=true" -q) || true