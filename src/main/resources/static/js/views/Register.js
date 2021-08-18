import createView from "../createView.js";

export default function Register(registration) {
    return `<!DOCTYPE html>
     <html lang="eng">
        <head>
            <meta charset="UTF-8"/>
            <title>Register</title>
        </head>
        <body>
            <h1>Register</h1>

            <form id="register-form">
                <label for="username">Username</label>
                <input id="username" name="username" type="text"/>
                <label for="email">Email</label>
                <input id="email" name="email" type="text"/>
                <label for="password">Password</label>
                <input id="password" name="password" type="password"/>
                <input id="register-btn" type="button" value="Register"/>
            </form>

        </body>
    </html>`;
}
export function RegisterEvent() {
    $("#register-btn").click(function () {
        let user = {
            username: $("#username").val(),
            email: $("#email").val(),
            password: $("#password").val()
        }
        let request = {
            method: "POST",
            header: {"Content-type": "application/json"},
            body: JSON.stringify(user)
        }
        fetch("http://localhost:8080/api/users").then((response) => {
            console.log(request.status);
            createView("/posts");
        });
    })
}