count=0
Max=0
arr=[]*2

for i in range(10):
    arr=list(map(int,input().split()))
    count=count-arr[0]+arr[1]
    if count>Max:
        Max=count
    
print(Max)