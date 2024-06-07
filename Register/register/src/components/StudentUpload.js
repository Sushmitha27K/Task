import axios from 'axios';
import React, { useState } from 'react';
const backgroundImage = 'url("https://img.freepik.com/free-photo/business-desk-arrangement-flat-lay_23-2148128268.jpg")';

const StudentUpload = () => {
    const [formData, setFormData] = useState({
        name: '', address: '', pincode: '', mobileNumber: '',
        file: null
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleFileChange = (e) => {
        setFormData({
            ...formData,
            file: e.target.files[0]
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        // Client-side validation
        if (!formData.name || !formData.address || !formData.pincode || !formData.mobileNumber || !formData.file) {
            alert('Please fill in all fields.');
            return;
        }
        const data = new FormData();
        data.append('name', formData.name);
        data.append('address', formData.address);
        data.append('pincode', formData.pincode);
        data.append('mobileNumber', formData.mobileNumber);
        data.append('file', formData.file);
        try {
            await axios.post('http://localhost:8080/api/employee/upload', data, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            });
            alert('Form uploaded successfully!');
        } catch (error) {
            console.error('There was an error uploading the form!', error);
            alert('There was an error uploading the form!');
        }
    };

    return (
        <div className="container-fluid " style={{ backgroundImage: backgroundImage, backgroundSize: 'cover', backgroundPosition: 'center', minHeight: '100vh' }}>
            <h6 className="mb-4 text-center" ></h6>
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <form onSubmit={handleSubmit}>
                        <div className="mb-2">
                            <label htmlFor="name" className="form-label">Name</label>
                            <input type="text" className="form-control" id="name" name="name" value={formData.name} onChange={handleChange} placeholder="Enter your name" required />
                        </div><br/>
                        <div className="mb-3">
                            <label htmlFor="address" className="form-label">Address</label>
                            <input type="text" className="form-control" name="address" value={formData.address} onChange={handleChange} placeholder="Enter your address" required />
                        </div><br/>
                        <div className="mb-3">
                            <label htmlFor="pincode" className="form-label">Pincode</label>
                            <input type="text" className="form-control" id="pincode" name="pincode" value={formData.pincode} onChange={handleChange} placeholder="Enter your pincode" required />
                        </div>
                        <br/>
                        <div className="mb-3">
                            <label htmlFor="mobileNumber" className="form-label">Mobile Number</label>
                            <input type="text" className="form-control" id="mobileNumber" name="mobileNumber" value={formData.mobileNumber} onChange={handleChange} placeholder="Enter your mobile number" required />
                        </div><br/>
                        <center><div className="mb-3">
                            <label htmlFor="file" className="form-label">Upload File</label>
                            <input type="file" className="form-control" id="file" name="file" onChange={handleFileChange} required />
                        </div><br/></center>
                        <button type="submit" className="btn btn-primary ">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default StudentUpload;