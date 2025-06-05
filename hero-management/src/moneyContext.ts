import { createContext } from "react";

export const MoneyContext = createContext({
  money: 0,
  refreshMoney: () => {},
  score: 0,
});
