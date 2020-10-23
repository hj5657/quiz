import React from 'react';
import Shop from './compoment/Shop';
import './App.css';
import Add from './compoment/Add';
import Order from './compoment/Order';
import { Link, Switch, BrowserRouter, Route } from 'react-router-dom';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <div className="head">
          <Link to="/" className="link">
            商城
          </Link>
          <Link to="/order" className="link">
            订单
          </Link>
          <Link to="/product" className="link">
            添加商品
          </Link>
        </div>

        <Switch>
          <Route exact path="/" component={Shop} />
          <Route path="/product" component={Add} />
          <Route path="/order" component={Order} />
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
