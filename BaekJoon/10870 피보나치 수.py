n=int(input())
arr=[0,1]
a=0
for i in range(n-1):
    a=arr[i]+arr[i+1]
    arr.append(a)
    i+=1

print(arr[n])  