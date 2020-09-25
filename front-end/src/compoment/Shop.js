import React,{Component} from "react";
import Product from './Product';
class Shop extends Component {
  constructor(props) {
    super(props);
    this.state = {
      goods: [
        {
          url: "",
          price: "",
          name: "",
        },
      ],
    };
  }
    render = () => {
        return ({
            this.state.goods.map(item => {
                return (<Product url={this.state.goods.url}
                    name={this.state.goods.name}
                    price={this.state.goods.price} />);
            })
        });
  }
  componentDidMount = async () => {
    const respons = await fetch("localhost:8080/items");
    const result = await respons.json();
    this.setState({
      goods: result,
    });
  };
}
export default Shop;
