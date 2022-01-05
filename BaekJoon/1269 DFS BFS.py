N,M,V=map(int,input().split())
#인접 행렬 생성
graph_matrix=[[0]*(N+1) for i in range(N+1)]
    
#간선 처리 
for i in range(M):
    a,b = map(int,input().split())
    graph_matrix[a][b]=graph_matrix[b][a]=1

visit_list=[0]*(N+1)#방문 여부 확인용 리스트

def dfs(V):
    visit_list[V]=1 #방문한 점 1로 표시
    print(V, end=' ')
    for i in range(1,N+1):
        if(visit_list[i]==0 and graph_matrix[V][i]==1):
            dfs(i)

def bfs(V):
    queue=[V] #들려야 할 정점 저장
    visit_list[V]=0 #방문한 점 0으로 표시
    
    while queue:#queue가 비어있지 않는 동안 실시
        V=queue.pop(0)
        print(V, end=' ')
        for i in range(1, N+1):#for문과 if문을 이용하여 해당 정점에서 탐색할 수 있는 모든 정점을 찾는다.
            if(visit_list[i]==1 and graph_matrix[V][i]==1):
                queue.append(i)
                visit_list[i]=0

dfs(V)
print()
bfs(V)