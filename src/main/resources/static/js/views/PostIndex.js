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
        </main>
    `;
}


export function postsEvent(){

    // its function is to add event listener, then after you add it, you're going to get the data from the post
    //  and then make a fetch request (method: post) which it will add a new blog post to the data base.

    const form = $('<form></form>');
    form.attr("method", "post");
    form.attr("action", "path");
    const field = $('<input></input>');

    field.attr("submit", "submit");

    form.append(field);
    $(document.body).append(form);
    form.submit();
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
