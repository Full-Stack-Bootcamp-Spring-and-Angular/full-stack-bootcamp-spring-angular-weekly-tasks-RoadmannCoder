<html>
<head>
    <title>Title</title>
</head>
<style>
    form {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }

    label {display: block;}

    input[type=text], select {
        width: 100%;
        padding: 12px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }
</style>
<body>
<h1>Register Information:</h1>
<form action="showConformationPage">
    <div>
        <label>First Name</label>
        <input type="text"  name="firstName" value=${firstName}>
    </div>
    <div >
        <label >Last Name</label>
        <input type="text"  name="lastName" value=${lastName}>
    </div>
    <div >
        <label>Email address</label>
        <input type="text"  name="emailAddress" value=${emailAddress}>
    </div>

    <div>
        <label>Date of Birth</label>
        <input type="text"  name="dob" value=${dob}>
    </div>

    <div>
        <label >City</label>
        <input type="text"  name="city" value=${city} >
    </div>
</form>

<h1>Data SuccessFully Registered</h1>
</body>
</html>
