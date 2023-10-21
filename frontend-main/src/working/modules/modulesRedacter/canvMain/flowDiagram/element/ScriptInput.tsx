import * as React from 'react'
import styled from 'styled-components'
import SelectSearch from "react-select-search";

const CustomInput = styled.input`
  width: 100%;
  height: 30px;
  padding-left: 0.5rem;
  border: 1px solid #d9d9d9;
  border-radius: 4px;
  outline: none;
  font-size: 14px;

  &:focus {
    box-shadow: 0 0 0 2px rgba(24, 144, 255, 0.2);
    border: 1px solid #10a9ff;
  }
`

export interface IInputProps {
    value: string
    type: any
    onChange: (e: any) => void
}

export const ScriptInput = ({ value, type, onChange }: IInputProps) => {
    return (
        // <CustomInput value={value} type={type} onChange={onChange} />
        <SelectSearch options={[]} value={value} onChange={onChange}
                      getOptions={(query) => {
                          return new Promise((resolve, reject) => {
                              fetch(
                                `presenter/api/scripts/?size=2&name=${query}`,
                              )
                                .then((response) => response.json())
                                .then(({ objects }) => {
                                    resolve(
                                      objects.map(({ name }) => ({
                                          value: name,
                                          name: name,
                                      })),
                                    );
                                })
                                .catch(reject);
                          });
                      }}
                      search={true} placeholder="Выберите скрипт"
        />
    )
}
