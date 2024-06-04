import anime from "../img/anime.jpg";

function ProfileAvatar(){
    return (
        <>
            <div className="w-12 rounded-full overflow-hidden">
                <img src={anime} />
            </div>
        </>
    )
}

export default ProfileAvatar;