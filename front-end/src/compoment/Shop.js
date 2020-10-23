import React, { Component } from 'react';
import Product from './Product';
class Shop extends Component {
  constructor(props) {
    super(props);
    this.state = {
      goods: [
        {
          url: '',
          price: '',
          name: '',
        },
      ],
    };
  }
  render() {
    return (
      <div className="content">
        {this.state.goods.map((item) => {
          return (
            <Product
              url={item.url}
              name={item.name}
              price={item.price}
              key=""
            />
          );
        })}
      </div>
    );
  }
  componentDidMount = async () => {
    const respons = await fetch('http://localhost:8080/items', {
      method: 'GET',
    });
    const result = await respons.json();
    this.setState({
      goods: result,
    });
  };
}
export default Shop;
