import createView from "../createView.js";
import {RegisterEvent} from "./Register.js";
import {getHeaders} from "../auth.js";

export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
<!--        MAKE CREATE FORM HERE-->
                <form>
                    <input id="title" type="text" placeholder="title">
                    <input id="content" type="text" placeholder="content">
                    <select>
                    <option value="">-- Select a Category --</option>
                    ${props.categories.map(category => `<option>${category.name}</option>`)}
                    </select>
                    <button type="submit" id="submit">submit</button>
                    
                </form>
            <div class="posts-container">
               ${getPostsComponent(props.posts)}
           
        </div>
        </main>
        `;

}

function getPostsComponent(posts) {
    console.log(posts)
    return posts.map(post => `
               <div class="post">
               
                   <h3 class="title-edit">${post.title}</h3>
                    <h2 class="content-edit">${post.content}</h2>
                    <h2 class="username">Posted By: ${post.user.username}</h2>
                    <div class="categories">
                    ${getCategoriesComponent(post.categories)}
                    <button type="button" class="edit" data-id="${post.id}">Edit</button>
                        <button type="button" class="delete" data-id="${post.id}">Delete</button>
                    
                 </div>`
    ).join('')
}

function getCategoriesComponent(categories) {

    console.log(categories);
    return categories.map(category => {
        return `
        <span>#${category.name}</span>
        `
    }).join('')
}

export function postsEvent() {
    createPostEvent();
    editEvent();
    deleteEvent();
    RegisterEvent();

}

function createPostEvent() {
    $("#submit").click(function () {
        console.log($("#title").val())
        let post = {
            title: $("#title").val(),
            content: $("#content").val()
            // add a property of the array of categories
        }

        let request = {
            method: "POST",
            headers: getHeaders(),
            body: JSON.stringify(post)
        }
        console.log(request)
        fetch("http://localhost:8080/api/posts", request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts")
        })
    })
}

function editEvent() {
    $(".edit").click(function () {

        $(".content-edit, .title-edit").attr("contenteditable", false);
        $(".edit").text("Edit");

        console.log("edit event fired off");
        $(this).siblings(".title-edit, .content-edit").attr("contenteditable", true);
        $(this).text("Save");
        $(this).on("click", function () {
            let post = {
                title: $(this).siblings(".title-edit").text(),
                content: $(this).siblings(".content-edit").text()
            }
            console.log("post is being saved");
            let request = {
                method: "PUT",
                headers: {"Content-type": "application/json"},
                body: JSON.stringify(post)
            }

            let id = $(this).attr("data-id")
            fetch(`http://localhost:8080/api/posts/${id}`, request)
                .then(res => {
                    console.log(res.status);
                    createView("/posts")
                }).catch(error => {
                console.log(error);
                createView("/posts")
            })
        })
    })
}


function deleteEvent() {
    $(".delete").click(function () {
        let request = {
            method: "DELETE",
            headers: {"Content-type": "application/json"},
        }

        let id = $(this).attr("data-id")
        fetch(`http://localhost:8080/api/posts/${id}`, request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts")
        })
    })
}
