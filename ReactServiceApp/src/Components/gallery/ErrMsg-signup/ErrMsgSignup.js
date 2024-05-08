import React from "react";
import styles from "./err.module.css";


const ErrMsgSignUp = () => {
  return (
    <>
      <div className={`${styles.ErrMsg}`}>
        <p>This Services is not available</p>
      </div>
    </>
  );
};

export default ErrMsgSignUp;
