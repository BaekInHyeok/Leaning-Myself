from collections import deque
N=int(input())
list_Numbers=list(map(int,input().split()))
list_Index=[]
result=[]

for i in range(1,N+1):
    list_Index.append(i)
    #ex)list_Index=[1,2,3,4,5]
    
idx=0
ballon_value=list_Numbers.pop(idx)#풍선에 쓰여있는 숫자
result.append(list_Index.pop(idx))#첫번째 풍선이 터지고 result에는 풍선의 순서(즉 1)이 삽입된다.

while(len(list_Numbers)>0):
    if ballon_value<0:
        idx=(idx+ballon_value)%len(list_Numbers)
    else:
        idx=(idx+ballon_value-1)%len(list_Numbers)
        
    ballon_value=list_Numbers.pop(idx)
    result.append(list_Index.pop(idx))
    
for i in range(N):
    print(result[i],end=' ')