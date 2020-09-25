import React from "react";
import Shop from "./compoment/Shop";
import "./App.css";
import Add from "./compoment/Add";
import { Link, Switch, BrowserRouter, Route } from "react-router-dom";
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Link to="/">商城</Link>
        <Link to="/">订单</Link>
        <Link to="/product">添加商品</Link>
        <Switch>
          <Route path="/" component={Shop} />
          <Route path="/product" component={Add} />
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
