import React, { createContext, useReducer } from "react";
import AppReducer from "./AppReducer";
import axios from "axios";

//Initial State
const initialState = {
  transactions: [],
  error: "",
  loading: true,
};

//create context
export const GlobalContext = createContext(initialState);

// create provider
export const GlobalProvider = ({ children }) => {
  const [state, dispatch] = useReducer(AppReducer, initialState);

  async function initTransactions() {
    await axios
      .get("/transactions/getAll")
      .then((res) => {
        dispatch({
          type: "INIT_TRANSACTIONS",
          payload: res.data,
        });
      })
      .catch((err) =>
        dispatch({
          type: "ERROR_TRANSACTION",
          payload: err,
        })
      );
  }

  async function deleteTransaction(id) {
    await axios
      .delete(`/transactions/transaction/${id}`)
      .then(() => {
        dispatch({
          type: "DELETE_TRANSACTION",
          payload: id,
        });
      })
      .catch((err) =>
        dispatch({
          type: "ERROR_TRANSACTION",
          payload: err,
        })
      );
  }

  async function addTransaction(transaction) {
    await axios
      .post(`/transactions/transaction/`, transaction)
      .then(() => {
        dispatch({
          type: "ADD_TRANSACTION",
          payload: transaction,
        });
      })
      .catch((err) =>
        dispatch({
          type: "ERROR_TRANSACTION",
          payload: err,
        })
      );
  }

  return (
    <GlobalContext.Provider
      value={{
        transactions: state.transactions,
        loading: state.loading,
        error: state.error,
        initTransactions,
        deleteTransaction,
        addTransaction,
      }}
    >
      {children}
    </GlobalContext.Provider>
  );
};
