M=int(input())
N=int(input())
arr=[]
sum=0


for i in range(M,N+1):
    count=0
    if i>1:
        for j in range(2,i):
            if i%j==0:
                count+=1
                break
        
        if count==0:
            arr.append(i)
        

for i in arr:
    sum=sum+i

if sum==0:
    print(-1)
else:
    print(sum)
    print(arr[0])