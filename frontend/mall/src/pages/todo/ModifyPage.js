import {useNavigate} from "react-router-dom";
import {useCallback} from "react";

const ModifyPage = ({tno}) => {
    const navigate = useNavigate()

    const moveToRead = useCallback(()=> {
        navigate({pathname: `/todo/read/${tno}`})
    },[navigate, tno])

    const moveToList = useCallback(() => {
        navigate({pathname: `/todo/list`})
    },[navigate])

    return (
        <div className="text-3xl font-extrabold">
            Todo Modify Page
        </div>
    )
}

export default ModifyPage;