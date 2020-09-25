import React from "react";
class Add extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      price: "",
      num: "",
      url: "",
    };
  }
  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };
  handleSubmit = (event) => {
    event.preventDefault();
    console.log(JSON.stringify(this.state));
  };
  render() {
    return (
      <div>
        <h1>添加商品</h1>
        <form onSubmit={this.handleSubmit}>
          <label>
            名称：
            <input
              type="text"
              name="name"
              value={this.state.name}
              onChange={this.handleChange}
            />
          </label>
          <label>
            价格：
            <input
              type="number"
              name="price"
              value={this.state.price}
              onChange={this.handleChange}
            />
          </label>
          <label>
            单位：
            <input
              type="text"
              name="num"
              value={this.state.num}
              onChange={this.handleChange}
            />
          </label>
          <label>
            图片：
            <input
              type="text"
              name="url"
              value={this.state.url}
              onChange={this.handleChange}
            />
          </label>
          <input
            type="submit"
            disabled={
              !this.state.name ||
              !this.state.price ||
              !this.state.url ||
              !this.state.num
            }
          />
        </form>
      </div>
    );
  }
}
export default Add;
