import createView from "../createView.js";
import {RegisterEvent} from "./Register.js";
export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
<!--        MAKE CREATE FORM HERE-->
                <form>
                    <input id="post-id" type="text" placeholder="Id">
                    <input id=title" type="text" placeholder="title">
                    <input id="content" type="text" placeholder="content">
                    <button type="submit" id="submit">submit</button>
                    
                </form>
            <div>
                ${props.posts.map(post =>`
                <div>
                    <h3 class="title-edit">${post.title}</h3>
                    <h2 class="content-edit">${post.content}</h2>
                    <button type="button" class="edit" data-id=${post.id}>Edit</button>
                        <button type="button" class="delete" data-id=${post.id}>Delete</button>
                    
                 </div>
                `).join('')}
           
        </div>
        </main>
    `;
}


export function postsEvent(){
    createPostEvent();
    editEvent();
    deleteEvent();
    RegisterEvent();

}

function createPostEvent(){
    $("#submit").click(function(){
        let post = {
            title: $("#title").val(),
            content: $("#content").val()
        }

        let request = {
            method: "POST",
            headers : {"Content-type":"application/json"},
            body: JSON.stringify(post)
        }

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

        $(".content-edit, .title-edit").attr("contenteditable",false);
        $(".edit").text("Edit");

        console.log("edit event fired off");
        $(this).siblings(".title-edit, .content-edit").attr("contenteditable",true);
        $(this).text("Save");
        $(this).on("click", function (){
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


    function deleteEvent(){
        $(".delete").click(function (){
            let request = {
                method: "DELETE",
                headers : {"Content-type":"application/json"},
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
