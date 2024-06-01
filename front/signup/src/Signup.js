import React, { useState } from 'react';
import axios from 'axios';

const Signup = () =>{
    const [member,setMember] = useState({
        memberEmail:'',
        memberPassword: '',
        memberName:''
    });

    const handleChange = (e) =>{
        const {name, value} = e.target;
        setMember({
            ...member,
            [name]: value
        });
    };

    const  handleSubmit = async (e) =>{
        e.preventDefault();
        try{
            const response = await axios.post('/api/member/save',member);
            console.log(response.data);
        }
        catch(error){
            console.error('회원가입 실패:',error);
        };

    }

    return(
        <form onSubmit={handleSubmit}>
        <div>
          <label>Email:</label>
          <input
            type="email"
            name="memberEmail"
            value={member.memberEmail}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Password:</label>
          <input
            type="password"
            name="memberPassword"
            value={member.memberPassword}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Name:</label>
          <input
            type="text"
            name="memberName"
            value={member.memberName}
            onChange={handleChange}
          />
        </div>
        <button type="submit">Sign Up</button>
      </form>
    );

};

export default Signup;