export default (state, action) => {
  switch (action.type) {
    case "INIT_TRANSACTIONS":
      return {
        ...state,
        transactions: action.payload,
        loading: false,
      };
    case "DELETE_TRANSACTION":
      return {
        ...state,
        transactions: state.transactions.filter(
          (transaction) => transaction.id !== action.payload
        ),
      };
    case "ADD_TRANSACTION":
      return {
        ...state,
        transactions: [...state.transactions, action.payload],
      };
    case "ERROR_TRANSACTION":
      return {
        ...state,
        error: action.payload,
      };
    default:
      return state;
  }
};
