import './App.css';
import {useEffect, useState} from "react";
import Axios from "axios";
import Lobby from "./Pages/Lobby";
import {Route, Routes} from "react-router-dom";
import Room from "./Pages/Room";
function App() {

  const [msg,setMsg]=useState('');

  useEffect(()=>{
    Axios.get("/test")
        .then(res=>setMsg(res.data));
  },[])

  return (
    <div className="App">
      {msg}
      <Routes>
        <Route path={"/"} element={<Lobby/>}/>
        <Route path={"/room/:roomId"} element={<Room/>}/>
      </Routes>
    </div>
  );
}

export default App;
