import './App.css';
import { useState,useEffect } from 'react';
function Hello(){
  //Which one looks better?

  //1
  useEffect(()=>{
    console.log("hi!")
    return()=>console.log("bye!")
  },[])

  //2
  useEffect(()=>{
    console.log("hi!")
    return function (){
      console.log("bye!")
    }
  },[])
}
function App() {
  const[showing,setShowing]=useState(false)
  const onClick=()=>setShowing((prev)=>!prev)
  return (
    <div>
      {showing ? <Hello /> : null}
      <button onClick={onClick}>{showing ? "Hide" : "Show"}</button>
    </div>
  );
}

export default App;
