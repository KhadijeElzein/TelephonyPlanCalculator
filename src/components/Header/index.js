import React from 'react';
import Navbar from 'react-bootstrap/Navbar'
import phone from '../../static/images/phone.svg'
const Header = () => (
<header>
<Navbar bg="info" variant="dark">
    <Navbar.Brand href="/">
      <img
        alt=""
        src={phone}
        width="30"
        height="30"
        className="d-inline-block align-top"
      />{' '}
      Telephony Plan Calculator
    </Navbar.Brand>
</Navbar>
</header>
);

export default Header;