import Card from "./Card";
import ProfileAvatar from "./ProfileAvatar";

function PostFormCreation(){
    return (
        <>
        <Card>
            <div className="flex gap-2">
                <div>
                    <ProfileAvatar />
                </div>
                <textarea className="grow py-3 h-14" placeholder="What's on your mind" />
            </div>
            <div className="flex gap-4 items-center mt-1 pl-1">
                <div>
                    <button className="flex gap-1">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                    <path strokeLinecap="round" strokeLinejoin="round" d="M2.25 15.75l5.159-5.159a2.25 2.25 0 013.182 0l5.159 5.159m-1.5-1.5l1.409-1.409a2.25 2.25 0 013.182 0l2.909 2.909m-18 3.75h16.5a1.5 1.5 0 001.5-1.5V6a1.5 1.5 0 00-1.5-1.5H3.75A1.5 1.5 0 002.25 6v12a1.5 1.5 0 001.5 1.5zm10.5-11.25h.008v.008h-.008V8.25zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z" />
                    </svg>
                        Add Image
                    </button>
                </div>
                <div className="grow text-right">
                    <button className="bg-blue-500 text-white px-6 py-1 rounded-md">Post</button>
                </div>
            </div>
        </Card>
        </>
    )
}

export default PostFormCreation;