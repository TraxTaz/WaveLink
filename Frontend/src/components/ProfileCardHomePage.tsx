import anime from "../img/anime.jpg"; 
import {Link} from "react-router-dom"

function ProfileCard(){
    return (
        <>
            <div className="w-86">
                <div className="bg-white rounded-3xl border border-slate-300/70 px-6 py-10 text-center transition duration-300 ease-in-out hover:border-slate-300/30 hover:shadow-lg">
                    <img className="mx-auto h-40 w-40 rounded-full object-cover xl:h-44 xl:w-44" src={anime} />
                <div className="mt-1 leading-6 ">
                    <h3 className="text-xl font-medium text-slate-900"><Link className="hover:underline cursor-pointer" to={"#"}>Traxidoo</Link></h3>
                </div>
                <p className="mt-1 text-base font-semibold text-red-600">
                    here is the bio
                </p>
                </div>
            </div>
        </>
    )
}

export default ProfileCard;