import Card from "./Card";
import ProfileAvatar from "./ProfileAvatar";
import {Link} from "react-router-dom";
import space from "../img/anime-space.jpg"


function Post(){
    return (
        <>
            <Card>
                <div className="flex gap-3">
                    <div>
                        <ProfileAvatar />
                    </div>
                    <div>
                        <p><Link className="font-semibold" to={"#"}>Name </Link>
                         shared a
                        <Link className="text-blue-500" to={"#"}> post</Link>
                        </p>
                        <p className="text-gray-500 text-sm">date</p>
                    </div>
                </div>
                <div>
                    <p className="my-3 text-sm">Lorem ipsum dolor sit amet. Eos autem fugit hic velit autem ea eaque sint vel dolore maiores. Ut dignissimos dicta 33 sunt explicabo ea galisum debitis id inventore voluptatem et dignissimos voluptatem.</p>
                    <div className="rounded-md overflow-hidden">
                        <img src={space} />
                    </div>
                </div>
                <div className="mt-4 flex gap-8">
                    <button className="flex gap-1 items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                    <path strokeLinecap="round" strokeLinejoin="round" d="M21 8.25c0-2.485-2.099-4.5-4.688-4.5-1.935 0-3.597 1.126-4.312 2.733-.715-1.607-2.377-2.733-4.313-2.733C5.1 3.75 3 5.765 3 8.25c0 7.22 9 12 9 12s9-4.78 9-12z" />
                    </svg>
                        101
                    </button>

                    <button className="flex gap-1 items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                    <path strokeLinecap="round" strokeLinejoin="round" d="M2.25 12.76c0 1.6 1.123 2.994 2.707 3.227 1.087.16 2.185.283 3.293.369V21l4.076-4.076a1.526 1.526 0 011.037-.443 48.282 48.282 0 005.68-.494c1.584-.233 2.707-1.626 2.707-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0012 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018z" />
                    </svg>
                    4
                    </button>
                </div>
                <div className="flex mt-6 gap-3">
                    <div>
                        <ProfileAvatar />
                    </div>
                    <textarea className="border grow p-3 px-4 h-12 overflow-hidden rounded-full" placeholder="Leave a comment" />
                </div>
            </Card>
        </>
    )
}

export default Post;