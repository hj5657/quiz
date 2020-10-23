import React from 'react';
import Shop from './compoment/Shop';
import './App.css';
import Add from './compoment/Add';
import { Link, Switch, BrowserRouter, Route } from 'react-router-dom';
function App() {
  return (
    <div className="App">
      <BrowserRouter key="head">
        <div className="head">
          <Link to="/" className="link">
            商城
          </Link>
          <Link to="/" className="link">
            订单
          </Link>
          <Link to="/product" className="link">
            添加商品
          </Link>
        </div>

        <Switch key="content">
          <Route exact path="/" component={Shop} />
          <Route path="/product" component={Add} />
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
