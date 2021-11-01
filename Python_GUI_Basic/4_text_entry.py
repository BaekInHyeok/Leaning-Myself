from tkinter import *

root=Tk()
root.title("Emmet's GUI")
root.geometry("640x480")

#텍스트 :  여러 줄 써야 할 때
txt=Text(root,width=30,height=5)
txt.pack()
txt.insert(END,"글자를 입력하세요")

#엔트리
e=Entry(root, width=30)
e.pack()
e.insert(0,"한 줄만 입력하세요")

def btncmd():
    #내용 가져오기
    print(txt.get("1.0",END)) #1:첫번째라인, 0:0번째 column 위치
    print(e.get())

    #내용 삭제하기
    txt.delete("1.0",END)
    e.delete(0,END)

btn=Button(root,text="클릭",command=btncmd)
btn.pack()

root.mainloop()