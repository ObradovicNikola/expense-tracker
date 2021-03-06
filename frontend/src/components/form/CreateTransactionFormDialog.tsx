import { Dialog, DialogContent, DialogTitle } from "@mui/material";
// import { FormikHelpers } from "formik";
import { GroupInterface } from "../../data/models/GroupInterface";
import { TransactionFormInterface } from "../../models/forms/TransactionFormInterface";
import TransactionFormikForm from "./common/TransactionFormikForm";
import { FormMetaInterface } from "./config/FormMetaInterface";

type Props = {
  title: string;
  isOpen: boolean;
  close: () => void;
  formMeta: FormMetaInterface;
  onSubmit: (values: TransactionFormInterface) => void;
  initialValues?: TransactionFormInterface;

  groupOptions: GroupInterface[];
};

const defaultInitialValues: TransactionFormInterface = {
  description: "",
  amount: 0,
  groupId: -1,
};

function CreateTransactionFormDialog({
  title,
  isOpen = false,
  close,
  formMeta,
  onSubmit: handleSubmit,
  initialValues = defaultInitialValues,
  groupOptions,
}: Props) {
  const onSubmit = async (
    values: TransactionFormInterface
    // actions: FormikHelpers<TransactionFormInterface>
  ) => {
    handleSubmit(values);
    // actions.resetForm();
  };

  return (
    <Dialog open={isOpen} onClose={close}>
      <DialogTitle>{title}</DialogTitle>
      <DialogContent className="pt-4">
        <TransactionFormikForm
          isLoading={formMeta.isSubmitting}
          handleClose={close}
          onSubmit={onSubmit}
          groups={groupOptions || []}
          initialValues={initialValues}
        />
      </DialogContent>
    </Dialog>
  );
}

export default CreateTransactionFormDialog;
