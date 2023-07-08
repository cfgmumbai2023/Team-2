// import React from 'react';
// import {
//   MDBRow,
//   MDBCol,
//   MDBInput,
//   MDBCheckbox,
//   MDBBtn
// } from 'mdb-react-ui-kit';

// export default function UserProfile() {
//   return (
//     <div className='col-12 align-items-center justify-content-center'>
//     <br>
//     </br>

//     <form className='col-6 align-items-center justify-content-center'>
//       <MDBRow className='mb-4'>
//         <MDBCol>
//           <MDBInput id='form6Example1' label='First name' />
//         </MDBCol>
//         <MDBCol>
//           <MDBInput id='form6Example2' label='Last name' />
//         </MDBCol>
//       </MDBRow>

//       <MDBInput wrapperClass='mb-4' id='form6Example3' label='Aadhar Number' />
//       <MDBInput wrapperClass='mb-4' id='form6Example4' label='Address' />
//       <MDBInput wrapperClass='mb-4' type='email' id='form6Example5' label='Email' />
//       <MDBInput wrapperClass='mb-4' type='tel' id='form6Example6' label='Phone' />

//       <MDBInput wrapperClass='mb-4' textarea id='form6Example7' rows={4} label='Additional information' />

//       <MDBCheckbox
//         wrapperClass='d-flex justify-content-center mb-4'
//         id='form6Example8'
//         label='Create an account?'
//         defaultChecked
//       />
//       <MDBBtn className='mb-4'  block>
//         Place order
//       </MDBBtn>
//     </form>
//     </div>
//   );
// }


import React, { useState } from 'react';
import {
      MDBRow,
      MDBCol,
      MDBInput,
      MDBCheckbox,
      MDBBtn
    } from 'mdb-react-ui-kit';
export default function UserProfile() {
    const [inputs, setInputs] = useState({
      firstName: '',
      lastName: '',
      aadharNumber: '',
      address: '',
      email: '',
      phone: '',
      additionalInfo: '',
      createAccount: false
    });
  
    const handleInputChange = (event) => {
      const { name, value, type, checked } = event.target;
      const inputValue = type === 'checkbox' ? checked : value;
  
      setInputs((prevInputs) => ({
        ...prevInputs,
        [name]: inputValue
      }));
    };
  
    const handleSubmit = (event) => {
      event.preventDefault();
      // Do something with the form data
      console.log(inputs);
    };
  
    return (
      <div className='col-12 align-items-center justify-content-center'>
        <br />
        <h1>Update your Profile</h1>
        <br></br>
        <form className='col-6 align-items-center justify-content-center' onSubmit={handleSubmit}>
          <MDBRow className='mb-4'>
            <MDBCol>
              <MDBInput
                id='form6Example1'
                label='First name'
                name='firstName'
                value={inputs.firstName}
                onChange={handleInputChange}
              />
            </MDBCol>
            <MDBCol>
              <MDBInput
                id='form6Example2'
                label='Last name'
                name='lastName'
                value={inputs.lastName}
                onChange={handleInputChange}
              />
            </MDBCol>
          </MDBRow>
  
          <MDBInput
            wrapperClass='mb-4'
            id='form6Example3'
            label='Aadhar Number'
            name='aadharNumber'
            value={inputs.aadharNumber}
            onChange={handleInputChange}
          />
          <MDBInput
            wrapperClass='mb-4'
            id='form6Example4'
            label='Address'
            name='address'
            value={inputs.address}
            onChange={handleInputChange}
          />
          <MDBInput
            wrapperClass='mb-4'
            type='email'
            id='form6Example5'
            label='Email'
            name='email'
            value={inputs.email}
            onChange={handleInputChange}
          />
          <MDBInput
            wrapperClass='mb-4'
            type='email'
            id='form6Example5'
            label='Email'
            name='email'
            value={inputs.email}
            onChange={handleInputChange}
          />
          <MDBInput
            wrapperClass='mb-4'
            type='tel'
            id='form6Example6'
            label='Phone'
            name='phone'
            value={inputs.phone}
            onChange={handleInputChange}
          />
  
          <MDBInput
            wrapperClass='mb-4'
            textarea
            id='form6Example7'
            rows={4}
            label='Additional information'
            name='additionalInfo'
            value={inputs.additionalInfo}
            onChange={handleInputChange}
          />
  
          <MDBCheckbox
            wrapperClass='d-flex justify-content-center mb-4'
            id='form6Example8'
            label='Create an account?'
            name='createAccount'
            checked={inputs.createAccount}
            onChange={handleInputChange}
          />
  
          <MDBBtn className='mb-4' block type='submit'>
            Place order
          </MDBBtn>
        </form>
      </div>
    );
  }
  