import createView from "../createView.js";

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
                    <h3>${post.title}</h3>
                    <h2>${post.content}</h2>
                    <button class="edit-btn" data-id="${post.id}">Edit</button>
                        <button class="delete-btn" data-id="${post.id}">Delete</button>
                    
                 </div>
                `).join('')}
           
        </div>
        </main>
    `;
}


export function postsEvent(){
    createPostEvent();
    editEvent();

    // its function is to add event listener, then after you add it, you're going to get the data from the post
    //  and then make a fetch request (method: post) which it will add a new blog post to the data base.

    // const form = $('<form></form>');
    // form.attr("method", "posts");
    // form.attr("action", "post");
    // const field = $('<input>' +
    //     'dfdfdddsfss</input>');
    //
    // field.attr("submit", "submit");
    //
    // form.append(field);
    // $(document.body).append(form);
    // form.submit();
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

function editEvent(){
    $(".edit-post-btn").click(function (){

        console.log("edit event fired off");
        $(this).siblings("[contentEditable=true]");
        $(this).text("Posts");

        fetch("http://localhost:8080/api/posts", request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts")
        })

        // get edit fields data - make a post object

        // make a request obj

        // send fetch request

    })


    function deleteEvent(){
        $(".delete-post-btn").click(function (){
            console.log("delete event fired off");
            $(this).siblings("[contentDeletable=true]");
            $(this).text("Posts");

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

}

