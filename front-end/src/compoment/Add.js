import React from 'react';
import { message } from 'antd';
class Add extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      price: '',
      num: '',
      url: '',
    };
  }
  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };
  handleSubmit = (event) => {
    event.preventDefault();
    fetch('http://localhost:8080/item', {
      method: 'POST',
      body: JSON.stringify({
        name: this.state.name,
        price: this.state.price,
        num: this.state.num,
        url: this.state.url,
      }),
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((data) => {
        if (data.status === 200) {
          this.setState({
            name: '',
            price: '',
            num: '',
            url: '',
          });
        }
        if (data.status === 400) {
          return Promise.reject({
            status: 400,
          });
        }
      })
      .catch((err) => {
        if (err.status === 400) {
          message.error('商品名称已存在，请输入新的商品名称');
        }
      });
  };
  render() {
    return (
      <div>
        <h1>添加商品</h1>
        <form onSubmit={this.handleSubmit}>
          <label>
            *名称：
            <input
              type="text"
              name="name"
              value={this.state.name}
              onChange={this.handleChange}
              placeholder="名称"
            />
          </label>
          <label>
            *价格：
            <input
              type="number"
              name="price"
              value={this.state.price}
              onChange={this.handleChange}
              placeholder="价格"
            />
          </label>
          <label>
            *单位：
            <input
              type="text"
              name="num"
              value={this.state.num}
              onChange={this.handleChange}
              placeholder="单位"
            />
          </label>
          <label>
            *图片：
            <input
              type="text"
              name="url"
              value={this.state.url}
              onChange={this.handleChange}
              placeholder="URL"
            />
          </label>
          <input
            className="submit"
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
