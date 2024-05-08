import React, { useContext, useState, useEffect } from "react";
import {
  Link,
  Outlet,
  Route,
  UNSAFE_ViewTransitionContext,
  useParams,
} from "react-router-dom";
import styles from "./stat.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBook } from "@fortawesome/free-solid-svg-icons"; // Import the specific FontAwesome icon
import { faUser } from "@fortawesome/free-solid-svg-icons"; // Import the specific FontAwesome icon
import { faCheck } from "@fortawesome/free-solid-svg-icons";
import axios from "axios";
import ErrMsg from "../ErrorMsg/ErrorMsg";
import ErrMsgSignUp from "../gallery/ErrMsg-signup/ErrMsgSignup";
const Stati = () => {
  const [borrow, Setborrow] = useState();
  const [users, Setusers] = useState();
  const [likeuwant, Setlike] = useState();
  const [search, setSearch] = useState("");
  const [x, setX] = useState([]);
  const [error, setError] = useState(false);
  const [name, setName] = useState("");
  const [selects, setSelects] = useState("");
  const [hide, setHide] = useState("hide");
  const [success, setSuccess] = useState(false);
  const [errormsg, setErrormsg] = useState("");
  const [server, setServer] = useState("none");
  const [serverd, setServerd] = useState("none");
  const [rerender, setRerender] = useState(false);



  const getAllBooks = () => {
    const apiurl = "http://localhost:9096/randomBookTitle";
    axios
      .get(apiurl)
      .then((res) => {
        Setlike(res.data);
        Setusers(res.data.userCount);
        console.log(res);
        setX(res.data);
        setError(false);
      })
      .catch((err) => {
        try {
          console.error("Add failed:", err.response.data);
          setErrormsg(err.response.data);
          setError(true);
          setSuccess(false);
        } catch (error) {
          console.log("erorr in server");
          window.alert("Error in server");
          setServer("block");
        }
      });
  };
  const dtime =()=>
    {
      const apiurl = "http://localhost:9095/datetime";
    axios
      .get(apiurl)
      .then((res) => {
        Setborrow(res.data);
        Setusers(res.data.userCount);
        console.log(res);
        setX(res.data);
        setError(false);
      })
      .catch((err) => {
        try {
          console.error("Add failed:", err.response.data);
          setErrormsg(err.response.data);
          setError(true);
          setSuccess(false);
        } catch (error) {
          console.log("erorr in server");
          window.alert("Error in server");
          setServerd("block");
        }
      });
    }
    useEffect(() => {
      dtime(); // Initial call
      const intervalId = setInterval(dtime, 5000); // Call every 5 seconds
    
      return () => clearInterval(intervalId); // Cleanup on unmount
    }, []);

  return (
    <>
      <section className={`${styles.stat}`}>
        <div className={`${styles.container}`}>
          <div className={`${styles.element}`}>
            <FontAwesomeIcon icon={faCheck} className={`${styles.icons}`} />{" "}
            <h3>{borrow}</h3>
            <h4>Date and time</h4>
            <div style={{ display: `${serverd}` }}>
              <ErrMsgSignUp />
            </div>
          </div>
          <div className={`${styles.element}`}>
            <FontAwesomeIcon icon={faBook} className={`${styles.icons}`} />
            <h3>{likeuwant}</h3>
            <h4>Get Recommendations from our Books</h4>
            <button onClick={getAllBooks}>Recommend</button>
            <div style={{ display: `${server}` }}>
              <ErrMsgSignUp />
            </div>
          </div>
        </div>
      </section>
    </>
  );
};

export default Stati;
