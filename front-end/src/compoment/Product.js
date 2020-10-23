import React from "react";
class Product extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }
  render() {
    return (
      <div className="product">
        <img src={this.props.url} alt="keleimg" />
        <p>{this.props.name}</p>
        <p>单价：{this.props.price}元</p>
      </div>
    );
  }
}
export default Product;
