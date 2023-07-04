import React, { useEffect, useState } from 'react';
import Axios from "axios";
import { Link } from "react-router-dom";

function Lobby(props) {
    const [lst, setlst] = useState([]);

    useEffect(() => {
        Axios.get("/lobby/list")
            .then(res => setlst(res.data))
            .catch(error => console.log(error));
    }, []);

    const RoomCreate = (e) => {
        let name = prompt("방제목 입력").trim();
        if (name.length === 0) {
            alert("방제목을 입력해주세요");
            return;
        } else {
            Axios.post("/lobby/create", null, { params: { name } })
                .then(res => setlst(res.data))
                .catch(error => console.log(error));
        }
    }

    return (
        <div>
            <button onClick={RoomCreate}>방만들기</button>
            <ul>
                {
                    Array.isArray(lst) && lst.map((dto, i) => (
                        <Link key={dto.roomId} to={"/room/" + dto.roomId}>
                            <li data-roomid={dto.roomId}>{i + 1}. {dto.roomName}</li>
                        </Link>
                    ))
                }
            </ul>
        </div>
    );
}

export default Lobby;
