import fetchData from "../fetchData";
import createView from "../createView";

export default function Register(registration) {
    return `<!DOCTYPE html>
     <html>
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
                <input id="login-btn" type="submit" value="Log In"/>
            </form>
            
            
        </body>
    </html>`;
}
function RegisterEvent() {
    $("#register-form").click(function () {
        let request = {
            method: "POST",
            body: {"Content-type": "application/json"},
        }
        fetchData(
            {
                route: `/api/users`
            },
            request).then((data) => {
            console.log(request.status);
            setTokens(data);
            createView("/");
        });
    })
}