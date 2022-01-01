N=int(input())

arr=list(map(int,input().split()))
num_count=0

for i in arr:
    count=0
    if i>1:
        for j in range(2,i):
            if i%j==0:
                count+=1
                
        if count==0:
            num_count+=1
                
        
print(num_count)
    