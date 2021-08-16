import createView from "../createView.js";

export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
<!--        MAKE CREATE FORM HERE-->
                <form>
                <div class="form-group">
                    <label for="post-id">post-id</label>
                    <input id="post-id" type="text" class="form-control" placeholder="Id">
                </div>
                <div class="form-group">
                     <label for="title-id">title</label>
                    <input id=title" type="text" class="form-control" placeholder="title">
                </div>
                <div class="form-group">
                     <label for="content">content</label>
                    <input id="content" type="text" class="form-control" placeholder="content">
                </div>
                    <button type="submit" id="submit" class="btn btn-primary">submit</button>
                </form>
            <div class="post-container">
                ${props.posts.map(post =>`<h3 >${post.title}</h3><h2>${post.content}</h2>`).join('')}
            </div>
</div>
        </main>
    `;
}


export function postsEvent(){
    createPostEvent();
    editEvent();

    // its function is to add event listener, then after you add it, you're going to get the data from the post
    //  and then make a fetch request (method: post) which it will add a new blog post to the data base.

    const form = $('<form></form>');
    form.attr("method", "post");
    form.attr("action", "path");
    const field = $('<input>' +
        'dfdfdddsfss</input>');

    field.attr("submit", "submit");

    form.append(field);
    $(document.body).append(form);
    form.submit();
}

function createPostEvent(){
    $("#create-post-btn").click(function(){
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
        $(this).text("Save");

        // get edit fields data - make a post object

        // make a request obj

        // send fetch request

    })
}


// export function postsEvent(path, params, method='post') {
    // function post(path, parameters) {
    //     const form = $('<form></form>');
    //
    //     form.attr("method", "post");
    //     form.attr("action", path);
    //
    //     $.each(parameters, function(key, value) {
    //         const field = $('<input></input>');
    //
    //         field.attr("name", key);
    //         field.attr("value", value);
    //
    //         form.append(field);
    //     });
    //

    //     // The form needs to be a part of the document in
    //     // order for us to be able to submit it.
    //     $(document.body).append(form);
    //     form.submit();
    // }
// }
