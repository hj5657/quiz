import React from "react";
class Product extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }
  render() {
    return (
      <div>
        <img src={this.props.url} alt="keleimg" />
        <p>{this.props.name}</p>
        <p>单价：{this.props.price}</p>
      </div>
    );
  }
}
export default Product;
