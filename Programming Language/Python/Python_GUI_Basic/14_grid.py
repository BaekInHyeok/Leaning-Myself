from tkinter import *

root=Tk()
root.title("Emmet's GUI")
root.geometry("640x480")

#계산기 재현
btn_f16=Button(root,text="F16",width=5,height=2)
btn_f17=Button(root,text="F17",width=5,height=2)
btn_f18=Button(root,text="F18",width=5,height=2)
btn_f19=Button(root,text="F19",width=5,height=2)
btn_f16.grid(row=0,column=0,sticky=N+E+W+S,padx=3,pady=3)
btn_f17.grid(row=0,column=1,sticky=N+E+W+S,padx=3,pady=3)
btn_f18.grid(row=0,column=2,sticky=N+E+W+S,padx=3,pady=3)
btn_f19.grid(row=0,column=3,sticky=N+E+W+S,padx=3,pady=3)

btn_clear=Button(root,text="clear",width=5,height=2)
btn_equal=Button(root,text="=",width=5,height=2)
btn_div=Button(root,text="/",width=5,height=2)
btn_mul=Button(root,text="*",width=5,height=2)
btn_clear.grid(row=1,column=0,sticky=N+E+W+S,padx=3,pady=3)
btn_equal.grid(row=1,column=1,sticky=N+E+W+S,padx=3,pady=3)
btn_div.grid(row=1,column=2,sticky=N+E+W+S,padx=3,pady=3)
btn_mul.grid(row=1,column=3,sticky=N+E+W+S,padx=3,pady=3)

btn_seven=Button(root,text="7",width=5,height=2)
btn_eight=Button(root,text="8",width=5,height=2)
btn_nine=Button(root,text="9",width=5,height=2)
btn_minus=Button(root,text="-",width=5,height=2)
btn_seven.grid(row=2,column=0,sticky=N+E+W+S,padx=3,pady=3)
btn_eight.grid(row=2,column=1,sticky=N+E+W+S,padx=3,pady=3)
btn_nine.grid(row=2,column=2,sticky=N+E+W+S,padx=3,pady=3) 
btn_minus.grid(row=2,column=3,sticky=N+E+W+S,padx=3,pady=3)

btn_four=Button(root,text="4",width=5,height=2)
btn_five=Button(root,text="5",width=5,height=2)
btn_six=Button(root,text="6",width=5,height=2)
btn_plus=Button(root,text="+",width=5,height=2)
btn_four.grid(row=3,column=0,sticky=N+E+W+S,padx=3,pady=3)
btn_five.grid(row=3,column=1,sticky=N+E+W+S,padx=3,pady=3)
btn_six.grid(row=3,column=2,sticky=N+E+W+S,padx=3,pady=3) 
btn_plus.grid(row=3,column=3,sticky=N+E+W+S,padx=3,pady=3)

btn_one=Button(root,text="1",width=5,height=2)
btn_two=Button(root,text="2",width=5,height=2)
btn_three=Button(root,text="3",width=5,height=2)
btn_enter=Button(root,text="enter")#세로로 합쳐져야 함
btn_one.grid(row=4,column=0,sticky=N+E+W+S,padx=3,pady=3)
btn_two.grid(row=4,column=1,sticky=N+E+W+S,padx=3,pady=3)
btn_three.grid(row=4,column=2,sticky=N+E+W+S,padx=3,pady=3) 
btn_enter.grid(row=4,column=3,rowspan=2,sticky=N+E+W+S,padx=3,pady=3)#현재 위치로부터 아래쪽으로 rowspan줄만큼 더함

btn_zero=Button(root,text="0",width=5,height=2)#가로로 합쳐져야 함
btn_point=Button(root,text=".",width=5,height=2)
btn_zero.grid(row=5,column=0,columnspan=2,sticky=N+E+W+S,padx=3,pady=3)#현재 위치로부터 우측으로 rowspan칸만큼 더함
btn_point.grid(row=5,column=2,sticky=N+E+W+S,padx=3,pady=3)

root.mainloop()