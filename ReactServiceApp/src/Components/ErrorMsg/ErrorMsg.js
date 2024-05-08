import React from "react";
import styles from "./error.module.css";


const ErrMsg = () => {
  return (
    <>
      <div className={`${styles.ErrMsg}`}>
        <p>This Services is not available</p>
      </div>
    </>
  );
};

export default ErrMsg;
