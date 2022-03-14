from tkinter import *

root=Tk()
root.title("Emmet's GUI")
root.geometry("640x480")

chkvar=IntVar()#chkvar에 int형으로 값 저장
chkbox=Checkbutton(root,text="오늘 하루 보지 않기",variable=chkvar)
chkbox.select()#선택된 상태로 처리
chkbox.deselect()#미선택된 상태로 처리
chkbox.pack()

chkvar2=IntVar()
chkbox2=Checkbutton(root,text="일주일동안 보지 않기",variable=chkvar2)
chkbox2.pack()

def btncmd():
    print(chkvar.get()) #0:체크해제 1:체크됨
    print(chkvar2.get())

btn=Button(root,text="클릭",command=btncmd)
btn.pack()

root.mainloop()