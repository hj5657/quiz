import React, { Component } from 'react';

class Order extends Component {
  constructor(props) {
    super(props);
    this.state = {
      orders: [
        {
          id: '',
          products: [],
          totalPrice: '',
        },
      ],
    };
  }
  componentDidMount = async () => {
    const respons = await fetch('http://localhost:8080/orders', {
      method: 'GET',
    });
    const result = await respons.json();
    this.setState({
      goods: result,
    });
  };
  render() {
    return (
      <div>
        {this.state.orders.length === 0 ? (
          <h3>暂无订单信息，请先去商城下单</h3>
        ) : (
          <div></div>
        )}
      </div>
    );
  }
}

export default Order;
