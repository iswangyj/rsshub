package com.test.util;

import com.test.enums.StateEnum;
import com.test.vo.ResultVO;

/**
 * @author Wyj
 * @date 2018/8/20
 */
public class ResultUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(StateEnum.SUCCESS.getState());
        resultVO.setMsg(StateEnum.SUCCESS.getMsg());

        return resultVO;
    }

    public static ResultVO idError() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(StateEnum.ID_ERROR.getState());
        resultVO.setMsg(StateEnum.ID_ERROR.getMsg());

        return resultVO;
    }

    public static ResultVO insertError() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(StateEnum.INSERT_ERROR.getState());
        resultVO.setMsg(StateEnum.INSERT_ERROR.getMsg());

        return resultVO;
    }

    public static ResultVO updateError() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(StateEnum.UPDATE_ERROR.getState());
        resultVO.setMsg(StateEnum.UPDATE_ERROR.getMsg());

        return resultVO;
    }

    public static ResultVO deleteError() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(StateEnum.DELETE_ERROR.getState());
        resultVO.setMsg(StateEnum.DELETE_ERROR.getMsg());

        return resultVO;
    }

    public static ResultVO objectIsDeleted() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(StateEnum.OBJECT_IS_DELETED.getState());
        resultVO.setMsg(StateEnum.OBJECT_IS_DELETED.getMsg());

        return resultVO;
    }

    public static ResultVO innerError() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(StateEnum.INNER_ERROR.getState());
        resultVO.setMsg(StateEnum.INNER_ERROR.getMsg());

        return resultVO;
    }
}

