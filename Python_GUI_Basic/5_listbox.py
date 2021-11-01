from tkinter import *

root=Tk()
root.title("Emmet's GUI")
root.geometry("640x480")

listbox=Listbox(root,selectmode="extended",height=3)
listbox.insert(0,"사과")
listbox.insert(1,"딸기")
listbox.insert(2,"바나나")
listbox.insert(END,"수박")
listbox.insert(END,"포도")
listbox.pack()

def btncmd():
   #삭제
   listbox.delete(END)#맨 뒤 항목 삭제. 0은 맨 앞 삭제

   #갯수 확인
   print("리스트에는", listbox.size(),"개가 있음")

   #항목확인
   print(listbox.get(0,2))#:1번째부터 3번째까지의 항목

   #선택된 항목 확인
   print(listbox.curselection())#인덱스값을 반환




btn=Button(root,text="클릭",command=btncmd)
btn.pack()

root.mainloop()