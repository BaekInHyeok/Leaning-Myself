
import './App.css';
import { useState,useEffect } from 'react';

function App() {
  const[counter,setValue]=useState(0);
  const[keyword,setKeyword]=useState("");
  const onClick=()=>setValue((prev) => prev+1)
  const onChange=(event)=>setKeyword(event.target.value)
  console.log("I run all the time");
  const IRunOnlyOnce=()=>{
    console.log("I run only once")
  }
  
  useEffect(IRunOnlyOnce,[]);//코드를 단 한번만 실행하도록 해준다

  useEffect(()=>{
    console.log("I run when keyword is changed",keyword)
  },[keyword]);//[]부분에 코드가 실행되는 변화가 적용되는 곳을 입력한다

  useEffect(()=>{
    console.log("I run when counter is changed",counter)
  },[counter]);
  return (
    <div>
      <h1>Welcome</h1>
      <hr />

      <input 
      value={keyword}
      onChange={onChange} 
      type="text" 
      placeholder="Search Here..." 
      />

      <h2>{counter}</h2>
      <button onClick={onClick}>Click Me</button>
    </div>
  );
}

export default App;
